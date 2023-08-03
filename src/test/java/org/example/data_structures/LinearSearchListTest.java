package org.example.data_structures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchListTest {

    @Test
    @DisplayName("Linear search list")
    void linearSearchList() {
        int[] foo = {1, 3, 4, 69, 71, 81, 90, 99, 420, 1337, 69420};
        assertTrue(LinearSearchList.linearSearchList(foo, 69));
        assertFalse(LinearSearchList.linearSearchList(foo, 1336));
        assertTrue(LinearSearchList.linearSearchList(foo, 69420));
        assertFalse(LinearSearchList.linearSearchList(foo, 69421));
        assertTrue(LinearSearchList.linearSearchList(foo, 1));
        assertFalse(LinearSearchList.linearSearchList(foo, 0));
    }
}