package com.example.pomodorotimer;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class PomodoroController {

    @FXML
    private Label timerLabel;

    @FXML
    private Button startButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button longBreakButton;

    @FXML
    private Button shortBreakButton;

    private Timeline timeline;
    private int minutes = 25;
    private int seconds = 0;

    private boolean isPaused = false;
    private int longBreakMinutes = 15;
    private int shortBreakMinutes = 5;

    public void initialize() {
        timerLabel.setText(formatTime(minutes, seconds));
        pauseButton.setDisable(false);
        startButton.setDisable(false);
    }

    public void toggleTimer(ActionEvent event) {
        if (timeline == null) {
            startTimer();
        } else {
            pauseTimer();
        }
    }

    public void startTimer() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (!isPaused) {
                if (seconds == 0) {
                    if (minutes == 0) {
                        timeline.stop();
                    } else {
                        minutes--;
                        seconds = 59;
                    }
                } else {
                    seconds--;
                }
                timerLabel.setText(formatTime(minutes, seconds));
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        startButton.setDisable(true);
        pauseButton.setDisable(false);
        shortBreakButton.setDisable(false);
        longBreakButton.setDisable(false);
    }

    public void pauseTimer() {
        if (!isPaused) {
            isPaused = true;
            pauseButton.setText("Resume");
        } else {
            isPaused = false;
            pauseButton.setText("Pause");
        }
    }

    public void resetTimer(ActionEvent event) {
        if (timeline != null) {
            timeline.stop();
        }
        minutes = 25;
        seconds = 0;
        isPaused = false;
        timerLabel.setText(formatTime(minutes, seconds));
        startButton.setDisable(false);
        pauseButton.setDisable(true);
    }

    public void setLongBreak(ActionEvent event) {
        minutes = longBreakMinutes;
        seconds = 0;
        timerLabel.setText(formatTime(minutes, seconds));
        if (timeline != null) {
            timeline.stop();
        }
        isPaused = false;
        startButton.setDisable(false);
        pauseButton.setDisable(false);
        startButton.setText("Start");
        pauseButton.setText("Pause");
        resetButton.setText("Reset");
    }

    public void setShortBreak(ActionEvent event) {
        minutes = shortBreakMinutes;
        seconds = 0;
        timerLabel.setText(formatTime(minutes, seconds));
        if (timeline != null) {
            timeline.stop();
        }
        isPaused = false;
        startButton.setDisable(false);
        pauseButton.setDisable(false);
        startButton.setText("Start");
        pauseButton.setText("Pause");
        resetButton.setText("Reset");
    }
    public void pomodoro(ActionEvent event) {
        minutes = 25;
        seconds = 0;
        timerLabel.setText(formatTime(minutes, seconds));
        if (timeline != null) {
            timeline.stop();
        }
        isPaused = false;
        startButton.setDisable(false);
        pauseButton.setDisable(false);
        startButton.setText("Start");
        pauseButton.setText("Pause");
        resetButton.setText("Reset");
    }

    private String formatTime(int min, int sec) {
        return String.format("%02d:%02d", min, sec);
    }
}
