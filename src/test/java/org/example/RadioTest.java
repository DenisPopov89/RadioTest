package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void setCurrentStation_shouldSetCurrentStation_whenValidStationProvided() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void setCurrentStation_shouldNotSetCurrentStation_whenInvalidStationProvided() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void nextStation_shouldSwitchToNextStation_whenNotAtMaxStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.nextStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void nextStation_shouldSwitchToFirstStation_whenAtMaxStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void prevStation_shouldSwitchToPrevStation_whenNotAtMinStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void prevStation_shouldSwitchToLastStation_whenAtMinStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void setVolume_shouldSetVolume_whenValidVolumeProvided() {
        Radio radio = new Radio();
        radio.setVolume(50);
        assertEquals(50, radio.getVolume());
    }

    @Test
    void setVolume_shouldNotSetVolume_whenInvalidVolumeProvided() {
        Radio radio = new Radio();
        radio.setVolume(-1);
        assertEquals(0, radio.getVolume());
        radio.setVolume(101);
        assertEquals(0, radio.getVolume());
    }

    @Test
    void increaseVolume_shouldIncreaseVolume_whenNotAtMaxVolume() {
        Radio radio = new Radio();
        radio.setVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getVolume());
    }

    @Test
    void increaseVolume_shouldNotIncreaseVolume_whenAtMaxVolume() {
        Radio radio = new Radio();
        radio.setVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getVolume());
    }

    @Test
    void decreaseVolume_shouldDecreaseVolume_whenNotAtMinVolume() {
        Radio radio = new Radio();
        radio.setVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getVolume());
    }

    @Test
    void decreaseVolume_shouldNotDecreaseVolume_whenAtMinVolume() {
        Radio radio = new Radio();
        radio.setVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getVolume());
    }
}