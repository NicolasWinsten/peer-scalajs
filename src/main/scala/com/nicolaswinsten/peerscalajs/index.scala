package com.nicolaswinsten.peerscalajs

import org.scalajs.dom.html.{Button, Input}
import org.scalajs.dom.raw.KeyboardEvent
import org.scalajs.dom.{Event, document}
import scalatags.JsDom.all._

import scala.scalajs.js

object index {
  val msgBox: Input = input(`type`:="text").render
  msgBox.onkeypress = (e: KeyboardEvent) =>
    if (e.key == "Enter") send(msgBox.value)
  val idInput: Input = input(`type`:="text").render
  val connectBtn: Button = button("Connect").render
  connectBtn.onclick = (_: Event) => join()


  val peer = new Peer(options = js.Dynamic.literal(debug = 2))
  var conn: js.UndefOr[DataConnection] = js.undefined
  peer.onOpen(id => println("ID: " + id))
  peer.onConnect(c => {
    conn = c
    println("Connected to: " + c.peer)
    ready()
  })
  peer.onError(err => println("Error: " + err))

  def ready(): Unit = {
    if (conn.isEmpty) println("WARNING: CONNECTION NOT MADE")
    else conn foreach { c =>
      c.onData(d => println("Data received: " + d))
      c.onClose(() => {
        println("connection closed")
        conn = js.undefined
      })
    }
  }

  def join(): Unit = {
    conn foreach (_.close())

    conn = peer.connect(idInput.value, js.Dynamic.literal(reliable = true))
    conn foreach { c =>
      c.onOpen(() => println("Connected to " + c.peer))
      c.onData(d => println("data received: " + d))
      c.onClose(() => println("Connection closed"))
    }
  }

  def send(data: String): Unit = conn.toOption match {
    case Some(c) if c.open =>
      msgBox.value = ""
      c.send(data)
      println("Sent: " + data)
    case _ => println("Connection is closed; cannot send data")
  }

  def main(args: Array[String]): Unit = {
    document.body.appendChild(idInput)
    document.body.appendChild(connectBtn)
    document.body.appendChild(hr.render)
    document.body.appendChild(msgBox)
  }
}
