package com.nicolaswinsten

import org.scalajs.dom.experimental.mediastream.MediaStream

import scala.scalajs.js


/**
 * Implicits providing quality of life methods on Peer, DataConnection, and MediaConnection
 */
package object peerscalajs {
  implicit class RichDataConnection private[peerscalajs](dc: DataConnection) {
    def onData(callback: js.Any => Unit): Unit          = dc.on("data", callback)
    def onOpen(callback: () => Unit): Unit              = dc.on("open", callback)
    def onClose(callback: () => Unit): Unit             = dc.on("close", callback)
    def onError(callback: js.Error => Unit): Unit       = dc.on("error", callback)
  }

  implicit class RichPeer private[peerscalajs](peer: Peer) {
    def onOpen(callback: String => Unit): Unit            = peer.on("open", callback)
    def onConnect(callback: DataConnection => Unit): Unit = peer.on("connection", callback)
    def onCall(callback: MediaConnection => Unit): Unit   = peer.on("call", callback)
    def onClose(callback: () => Unit): Unit               = peer.on("close", callback)
    def onDisconnect(callback: () => Unit): Unit          = peer.on("disconnected", callback)
    def onError(callback: js.Error => Unit): Unit         = peer.on("error", callback)
  }

  implicit class RichMediaConnection private[peerscalajs](mc: MediaConnection) {
    def onStream(callback: MediaStream => Unit): Unit = mc.on("stream", callback)
    def onClose(callback: () => Unit): Unit           = mc.on("close", callback)
    def onError(callback: js.Error => Unit): Unit     = mc.on("error", callback)
  }
}
