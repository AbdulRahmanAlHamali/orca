/*
 * Copyright 2017 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.orca.q.events

import com.netflix.spinnaker.orca.time.toInstant
import org.springframework.context.ApplicationEvent

sealed class QueueEvent(source: Any) : ApplicationEvent(source) {

  class QueuePolled(source: Any) : QueueEvent(source)
  class RetryPolled(source: Any) : QueueEvent(source)
  class MessagePushed(source: Any) : QueueEvent(source)
  class MessageAcknowledged(source: Any) : QueueEvent(source)
  class MessageRetried(source: Any) : QueueEvent(source)
  class MessageDead(source: Any) : QueueEvent(source)

  val instant
    get() = timestamp.toInstant()
}
