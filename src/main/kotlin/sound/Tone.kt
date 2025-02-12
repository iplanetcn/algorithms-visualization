package sound

import javax.sound.sampled.*
import kotlin.math.sin
import kotlin.math.PI

object ToneGenerator {

    fun playTone(frequency: Float, duration: Int, volume: Float) {
        try {
            val sampleRate = 44100f // Samples per second
            val numSamples = duration * sampleRate / 1000 // Number of samples

            val buffer = FloatArray(numSamples.toInt())

            for (i in buffer.indices) {
                val angle = 2.0 * PI * frequency * i / sampleRate
                buffer[i] = (volume * sin(angle)).toFloat() // Sine wave
            }

            val audioFormat = AudioFormat(sampleRate, 16, 1, true, false) // 16-bit, mono, signed, little-endian
            val dataLineInfo = DataLine.Info(SourceDataLine::class.java, audioFormat)

            val sourceDataLine = AudioSystem.getLine(dataLineInfo) as SourceDataLine
            sourceDataLine.open(audioFormat)
            sourceDataLine.start()

            val byteBuffer = ByteArray(buffer.size * 2) // 2 bytes per sample (16-bit)
            var index = 0
            for (sample in buffer) {
                val shortSample = (sample * 32767).toInt().toShort() // Scale to 16-bit range
                byteBuffer[index++] = (shortSample.toInt() and 0xFF).toByte() // Low byte
                byteBuffer[index++] = (shortSample.toInt() shr 8).toByte() // High byte
            }

            sourceDataLine.write(byteBuffer, 0, byteBuffer.size)

            sourceDataLine.drain()
            sourceDataLine.stop()
            sourceDataLine.close()

        } catch (e: Exception) {
            println("Error playing tone: ${e.message}")
            e.printStackTrace()
        }
    }
}