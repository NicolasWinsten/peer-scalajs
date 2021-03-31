package com.nicolaswinsten.peerscalajs

import org.scalajs.dom.experimental.mediastream.MediaStream

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSImport}

@js.native
@JSImport("peerjs.min.js", JSImport.Default)
class Peer extends js.Object {
  def this(id: String = ???, options: js.Object = ???) = this()
  def connect(id: String, options: js.Object = ???): DataConnection                     = js.native
  def on(event: String, callback: js.Function): Unit                                    = js.native
  def call(id: String, stream: MediaStream, options: js.Object = ???): MediaConnection  = js.native
  def disconnect(): Unit                                                                = js.native
  def reconnect(): Unit                                                                 = js.native
  def destroy(): Unit                                                                   = js.native
  def id: String                                                                        = js.native
  def connections: js.Object                                                            = js.native
  def disconnected: Boolean                                                             = js.native
  def destroyed: Boolean                                                                = js.native
}




