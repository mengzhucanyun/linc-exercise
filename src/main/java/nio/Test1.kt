package nio

import java.io.File
import java.io.RandomAccessFile
import java.nio.ByteBuffer
import java.nio.IntBuffer
import java.nio.channels.Channel
import java.nio.channels.Channels
import java.nio.channels.FileChannel
import java.nio.file.AccessMode

/**
 *  Created by linc on 2019/4/4.
 */
class Test1 {

    companion object {
        @JvmStatic
        fun main(str: Array<String>) {

            val tester:Test1= Test1()
            tester.testChannel()

        }
    }

    fun testBuffer() {
        val buffer: IntBuffer = IntBuffer.allocate(10)
        for (i in 1..10)
            buffer.put(i)

        buffer.flip()
        while (buffer.hasRemaining())
            System.out.println(buffer.get())
    }

    fun testChannel() {
        val file: File = File("/Users/huangjunlin/Documents/index.html")
        val randomAccessFile: RandomAccessFile = RandomAccessFile(file, "rw")
        val channel: FileChannel = randomAccessFile.channel
        val buffer: ByteBuffer = ByteBuffer.allocate(64)
        var i: Int = channel.read(buffer)
        while (i > -1) {
            buffer.flip()
            while (buffer.hasRemaining())
                System.out.print(buffer.get())
            buffer.clear()
            i=channel.read(buffer)
        }
    }

}