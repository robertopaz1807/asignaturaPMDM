package com.miteris.sensorrotacionvector

import android.content.ContentValues
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val rotationVectorSensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)

        if (rotationVectorSensor == null){
            Log.e(ContentValues.TAG," NO tiene sensor de Vector de Rotacion")
            finish()
        }

        // Create a listener
        val rvListener : SensorEventListener = object : SensorEventListener {
            override fun onSensorChanged(sensorEvent: SensorEvent) {

                val rotationMatrix = FloatArray(16)
                SensorManager.getRotationMatrixFromVector(
                    rotationMatrix, sensorEvent.values
                )

                // Remap coordinate system
                val remappedRotationMatrix = FloatArray(16)
                SensorManager.remapCoordinateSystem(
                    rotationMatrix,
                    SensorManager.AXIS_X,
                    SensorManager.AXIS_Z,
                    remappedRotationMatrix
                )

                // Convert to orientations
                val orientations = FloatArray(3)
                SensorManager.getOrientation(remappedRotationMatrix, orientations)

                for (i in 0..2) {
                    orientations[i] = Math.toDegrees(orientations[i].toDouble()).toFloat()
                }

                if(orientations[2] > 45) {
                    window.decorView.setBackgroundColor(Color.YELLOW);
                } else if(orientations[2] < -45) {
                    window.decorView.setBackgroundColor(Color.BLUE);
                } else if(Math.abs(orientations[2]) < 10) {
                    window.decorView.setBackgroundColor(Color.WHITE);
                }

            }
            override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
        }

        // Register the listener
        sensorManager.registerListener(
            rvListener,
            rotationVectorSensor, SensorManager.SENSOR_DELAY_NORMAL
        )




    }
}