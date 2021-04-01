package com.nicolaswinsten.peerscalajs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("peerjs.util")
object util extends js.Object {
  def browser: String = js.native
  def supports: Supports = js.native

  trait Supports extends js.Object {
    def audioVideo: js.UndefOr[Boolean]
    def data:       js.UndefOr[Boolean]
    def binary:     js.UndefOr[Boolean]
    def reliable:   js.UndefOr[Boolean]
  }
}
