package com.uryoya.sssp

import com.twitter.app.App
import com.twitter.finagle.Http
import com.twitter.util.Await

object Server extends App {
  def main(): Unit = {

    val addr   = s":${config.server.port}"
    val server = Http.server.serve(addr, new Api().service)

    onExit { Await.result(server.close) }

    Await.ready(server)
  }
}
