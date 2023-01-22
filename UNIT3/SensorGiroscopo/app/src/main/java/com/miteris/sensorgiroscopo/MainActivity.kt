package com.miteris.sensorgiroscopo

import android.content.ContentValues
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val gyroscopeSensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        if (gyroscopeSensor == null){
            Log.e(ContentValues.TAG," NO tiene sensor de Giroscopio")
            finish()
        }

        // Create a listener
        val gyroscopeSensorListener: SensorEventListener = object : SensorEventListener {
            override fun onSensorChanged(sensorEvent: SensorEvent) {
                if(sensorEvent.values[2] > 0.5f) { // anticlockwise
                    window.decorView.setBackgroundColor(Color.BLUE)
                    playSoundGato()
                } else if(sensorEvent.values[2] < -0.5f) { // clockwise
                    window.decorView.setBackgroundColor(Color.YELLOW)
                    pauseSound()
                }
            }
            override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
        }

       // Register the listener
        sensorManager.registerListener(
            gyroscopeSensorListener,
            gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL
        )
    }



    //Reproducir musica
    //0.- Declaramos lavariable
    var mMediaPlayer: MediaPlayer? = null

    // 1. Plays the sound GATO
    fun playSoundGato() {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.gato)
            // Quitar si no queremos que se repita
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }

    // 2. Pause playback
    fun pauseSound() {
        if (mMediaPlayer?.isPlaying == true) mMediaPlayer?.pause()
    }

    // 3. Stops playback
    fun stopSound() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    // 4. Destroys the MediaPlayer instance when the app is closed
    override
    fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }




}