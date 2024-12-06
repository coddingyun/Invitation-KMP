package org.example.invitation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlin.wasm.unsafe.UnsafeWasmMemoryApi
import kotlin.wasm.unsafe.withScopedMemoryAllocator
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.readResourceBytes
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Int8Array
import org.w3c.fetch.Response


private val notoColorEmoji = "./NotoColorEmoji.ttf"

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        val fontFamilyResolver = LocalFontFamilyResolver.current
        val (fontsLoaded, setFontsLoaded) = remember { mutableStateOf(false) }
        val app = remember { App() }
        app.Content()
//        if (fontsLoaded) {
//            app.Content()
//        } else {
//            // 로딩 중일 때 보여줄 UI (예: 로딩 텍스트)
//            Text("Loading fonts...")
//        }
        var fontIBMPlex by remember { mutableStateOf<FontFamily?>(null) }
        LaunchedEffect(Unit) {
            val fontData = loadResource("NotoColorEmoji.ttf")
            fontIBMPlex = FontFamily(
                Font(identity = "NotoColorEmoji", data = fontData)
            )
            setFontsLoaded(true)
//            try {
//                val notoEmojisBytes = loadRes(notoColorEmoji) // loadRes 문제 있는 것 확실함
//                val fontFamily = FontFamily(listOf(Font("NotoColorEmoji", notoEmojisBytes.toByteArray())))
//                fontFamilyResolver.preload(fontFamily)
//                setFontsLoaded(true)
//            } catch (e: Exception) {
//                println("Error loading fonts: ${e.message}")
//            }
        }
//        val app = App()
//        app.Content()
    }
}

@OptIn(InternalResourceApi::class)
suspend fun loadResource(path: String): ByteArray {
    return readResourceBytes(path)
}

suspend fun loadRes(url: String): ArrayBuffer {
    return window.fetch(url).await<Response>().arrayBuffer().await()
}


fun ArrayBuffer.toByteArray(): ByteArray {
    val source = Int8Array(this, 0, byteLength)
    return jsInt8ArrayToKotlinByteArray(source)
}


external fun jsExportInt8ArrayToWasm(src: Int8Array, size: Int, dstAddr: Int)

internal fun jsInt8ArrayToKotlinByteArray(x: Int8Array): ByteArray {
    val size = x.length

    try {
        @OptIn(UnsafeWasmMemoryApi::class)
        return withScopedMemoryAllocator { allocator ->
            val memBuffer = allocator.allocate(size)
            val dstAddress = memBuffer.address.toInt()
            jsExportInt8ArrayToWasm(x, size, dstAddress)
            ByteArray(size) { i -> (memBuffer + i).loadByte() }
        }
    } catch (e: Exception) {
        println("Error in jsInt8ArrayToKotlinByteArray: ${e.message}")
        throw e
    }
}