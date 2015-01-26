/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.scalar.lang

import org.apache.ignite.internal.util.lang.GridPeerDeployAwareAdapter
import org.apache.ignite.lang.IgniteOutClosure

import java.util.concurrent.Callable

/**
 * Peer deploy aware adapter for Java's `GridOutClosure`.
 */
class ScalarOutClosure[R](private val f: () => R) extends GridPeerDeployAwareAdapter
    with IgniteOutClosure[R] with Callable[R] {
    assert(f != null)

    peerDeployLike(f)

    /**
     * Delegates to passed in function.
     */
    def apply: R = {
        f()
    }

    /**
     * Delegates to passed in function.
     */
    def call: R = {
        f()
    }
}
