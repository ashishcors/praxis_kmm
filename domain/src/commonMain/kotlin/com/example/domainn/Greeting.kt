package com.example.domainn

class Greeting {
  fun greeting(): String {
    return "Hello, ${Platform().platform}!"
  }
}