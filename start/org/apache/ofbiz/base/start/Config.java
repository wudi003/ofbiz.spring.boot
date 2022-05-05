/*
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
 */
package org.apache.ofbiz.base.start;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;
import java.util.TimeZone;

/**
 * OFBiz server parameters needed on system startup and retrieved from
 * one of the properties files in the start component
 */
public final class Config {
    /** The default directory where log files are stored. */
    private static final Path DEFAULT_LOG_DIRECTORY = Paths.get("runtime", "logs");

    private  Path ofbizHome;
    private  InetAddress adminAddress;
    private  String adminKey;
    private  int portOffset;
    private  int adminPort;
    private  List<String> loaders;
    private  Path logDir;
    private  boolean shutdownAfterLoad;
    private  boolean useShutdownHook;

    public Path getLogDir() {
        return logDir;
    }

    public List<String> getLoaders() {
        return loaders;
    }

    public boolean isShutdownAfterLoad() {
        return shutdownAfterLoad;
    }

    public boolean isUseShutdownHook() {
        return useShutdownHook;
    }

    public InetAddress getAdminAddress() {
        return adminAddress;
    }

    public String getAdminKey() {
        return adminKey;
    }

    public int getAdminPort() {
        return adminPort;
    }

    public int getPortOffset() {
        return portOffset;
    }

    public Path getOfbizHome() {
        return ofbizHome;
    }

 
}
