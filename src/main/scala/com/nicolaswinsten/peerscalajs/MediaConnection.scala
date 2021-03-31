package com.nicolaswinsten.peerscalajs

import org.scalajs.dom.experimental.mediastream.MediaStream

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal
class MediaConnection extends js.Object {
  def answer(stream: MediaStream, options: js.Object): Unit = js.native
  def close(): Unit                                         = js.native
  def on(event: String, callback: js.Function): Unit        = js.native
  def open: Boolean                                         = js.native
  def metadata: js.Any                                      = js.native
  def peer: String                                          = js.native
  def `type`: String                                        = js.native
}
