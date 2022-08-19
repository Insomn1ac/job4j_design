package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkNameArrayIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is empty");
    }

    @Test
    void checkNameWithoutAKey() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("=q", "test=test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("=q")
                .hasMessageContaining("key");
    }

    @Test
    void checkNameWithoutAValue() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("test=test", "qwerty="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("qwerty=")
                .hasMessageContaining("value");
    }

    @Test
    void checkNameArrayWithoutEqualsSign() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("qwerty", "test=test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("qwerty")
                .hasMessageContaining("\"=\"");
    }
}