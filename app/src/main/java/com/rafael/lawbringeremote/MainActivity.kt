package com.rafael.lawbringeremote

import android.content.Context
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.seismic.ShakeDetector

class MainActivity : AppCompatActivity(), MainView {

    lateinit
    var mediaPlayer: MediaPlayer

    lateinit
    var shakeDetector: ShakeDetector

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.lawbringer_emote)
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        shakeDetector = ShakeDetector(this)
        shakeDetector.start(sensorManager)
    }

    override
    fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    override
    fun hearShake() {
        mediaPlayer.stop()
        mediaPlayer.prepare()
        mediaPlayer.start()
    }
}
