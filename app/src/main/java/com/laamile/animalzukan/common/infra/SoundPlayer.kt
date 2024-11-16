package com.laamile.animalzukan.common.infra

import android.media.MediaPlayer
import javax.inject.Inject

class SoundPlayer @Inject constructor(private val mediaPlayer: MediaPlayer) {

    fun playSoundFromUrl(soundUrl: String) {
        stopSound()
        mediaPlayer.apply {
            reset() // 再利用可能にするためリセット
            setDataSource(soundUrl)
            prepareAsync()
            setOnPreparedListener { start() }
            setOnCompletionListener { stopSound() }
        }
    }

    fun stopSound() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.reset()
    }
}

