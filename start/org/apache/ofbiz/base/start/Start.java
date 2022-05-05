/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package org.apache.ofbiz.base.start;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.apache.ofbiz.base.container.ContainerLoader;

/**
 * OFBiz startup class.
 *
 * <p>
 * This class implements a thread-safe state machine. The design is critical
 * for reliable starting and stopping of the server.
 * </p>
 * <p>
 * The machine's current state and state changes must be encapsulated in this
 * class. Client code may query the current state, but it may not change it.
 * </p>
 * <p>
 * This class uses a singleton pattern to guarantee that only one server instance
 * is running in the VM. Client code retrieves the instance by using the
 * {@code getInstance()} static method.
 * </p>
 */
public final class Start {
	 private Config config = null;
    private ContainerLoader loader = new ContainerLoader();
    private final AtomicReference<ServerState> serverState = new AtomicReference<>(ServerState.STARTING);

    // Singleton, do not change
    private static final Start INSTANCE = new Start();
    private Start() {
    }

   

    /**
     * Returns the <code>Start</code> instance.
     */
    public static Start getInstance() {
        return INSTANCE;
    }


    /**
     * Returns the server's current state.
     */
    public ServerState getCurrentState() {
        return serverState.get();
    }


    /**
     * This enum contains the possible OFBiz server states.
     */
    public enum ServerState {
        STARTING, RUNNING, STOPPING;

        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase(Locale.getDefault());
        }
    }

    /**
     * The type of command that allow dispatching to various startup behavior.
     */
    private enum CommandType {
        HELP, STATUS, SHUTDOWN, START;
        
    }

    /**
     * Returns the server's main configuration.
     */
    public Config getConfig() {
        return this.config;
    }
}
