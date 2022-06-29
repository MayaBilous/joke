package com.maya.joke.corutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ScopeClass {
    val scope = CoroutineScope(Dispatchers.IO)
}