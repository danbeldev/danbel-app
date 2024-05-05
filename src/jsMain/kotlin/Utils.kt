import kotlinx.browser.window

actual fun openLinkInBrowser(url: String) {
    window.open(url)
}