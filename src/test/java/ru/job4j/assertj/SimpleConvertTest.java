package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("five")
                .contains("four", Index.atIndex(3))
                .anySatisfy((e) -> assertThat(e).isEqualTo("three"))
                .allSatisfy((e) -> assertThat(e.length()).isLessThanOrEqualTo(6));

    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "five", "three", "four", "first");
        assertThat(set).hasSize(4)
                .doesNotContain("second")
                .contains("four")
                .anySatisfy((e) -> assertThat(e).isEqualTo("first"))
                .noneSatisfy((e) -> assertThat(e.length()).isGreaterThanOrEqualTo(6))
                .containsExactlyInAnyOrder("three", "five", "four", "first");

    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .doesNotContainKey("six")
                .containsValues(4, 2)
                .anySatisfy((k, v) -> assertThat(v).isEqualTo(4))
                .noneSatisfy((k, v) -> assertThat(v).isGreaterThanOrEqualTo(6))
                .containsEntry("three", 3);

    }
}