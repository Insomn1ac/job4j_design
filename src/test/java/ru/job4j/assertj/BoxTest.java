package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void whenBoxIsSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
        assertThat(box.isExist()).isTrue();
        assertThat(box.getNumberOfVertices()).isEqualTo(0);
        assertThat(box.getArea()).isCloseTo(1257D, Percentage.withPercentage(1D));
    }

    @Test
    void whenBoxIsCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
        assertThat(box.isExist()).isTrue();
        assertThat(box.getNumberOfVertices()).isEqualTo(8);
        assertThat(box.getArea()).isEqualTo(600D);
    }

    @Test
    void whenBoxIsTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
        assertThat(box.isExist()).isTrue();
        assertThat(box.getNumberOfVertices()).isEqualTo(4);
        assertThat(box.getArea()).isCloseTo(175D, Percentage.withPercentage(2D));
    }

    @Test
    void whenBoxIsUnknownObject() {
        Box box = new Box(1, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
        assertThat(box.isExist()).isFalse();
        assertThat(box.getNumberOfVertices()).isLessThan(4);
        assertThat(box.getArea()).isEqualTo(0D);
    }
}