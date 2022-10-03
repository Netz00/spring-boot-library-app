package com.netz00.libraryapp.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Data JPA tests for {@link Author}.
 *
 * @author Phillip Webb
 */
@DataJpaTest
public class AuthorEntityTest {

    @Autowired
    private TestEntityManager entityManager;


    @Test
    void createWhenNameIsNullShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Author(null, "Fowler", 1970, null, "male", "Five star general"))
                .withMessage("Name must not be empty");
    }

    @Test
    void createWhenNameIsEmptyShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Author("", "Fowler", 1970, null, "male", "Five star general"))
                .withMessage("Name must not be empty");
    }


    @Test
    void createWhenNameIsTooLongShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Author("123456789012345678901", "Fowler", 1970, null, "male", "Five star general"))
                .withMessage("Name must be between 1 and 20 characters long");
    }


    @Test
    void createWhenFamilyIsTooLongShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Author("Martin", "12345678901234567890123456789012345678901", 1970, null, "male", "Five star general"))
                .withMessage("Family name must be between 1 and 40 characters long");
    }


    @Test
    void createWhenBirtYearIsInTheFutureShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Author("Martin", "Fowler", Year.now().getValue() + 1, null, "male", "Five star general"))
                .withMessage("Birth year must be in the past");
    }

    @Test
    void createWhenDeathYearIsInTheFutureShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Author("Martin", "Fowler", Year.now().getValue() - 10, Year.now().getValue() + 1, "male", "Five star general"))
                .withMessage("Death year must be in the past");
    }


    @Test
    void createWhenDeathYearIsBeforeBirtYearShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Author("Martin", "Fowler", Year.now().getValue() - 10, Year.now().getValue() - 11, "male", "Five star general"))
                .withMessage("Death year must be after birth year");
    }


    @Test
    void createWhenNoteYearIsTooLongShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Author("Martin", "Fowler", null, null, "male", "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901"))
                .withMessage("Note must be up to 200 characters max");
    }


    @Test
    void saveShouldPersistData() {
        Author author = this.entityManager.persistFlushFind(new Author("Martin", "Fowler", 1970, null, "male", "Five star general"));
        assertThat(author.getName()).isEqualTo("Martin");
        assertThat(author.getFamily_name()).isEqualTo("Fowler");
        assertThat(author.getBirth_year()).isEqualTo(1970);
        assertThat(author.getDeath_year()).isNull();
        assertThat(author.getGenre()).isEqualTo("male");
        assertThat(author.getNote()).isEqualTo("Five star general");
    }

}
