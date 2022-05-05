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

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * A utility class for processing OFBiz command line arguments
 *
 * <p>
 * Defines OFBiz startup options called through main e.g. --load-data or --help
 * in addition to utility methods for parsing and handling these options
 * </p>
 */
public final class StartupCommandUtil {

    private StartupCommandUtil() { }
    /*
     * Make sure of defining the same set of values in:
     * - The StartupOptions in the StartupOption enum
     * - The commons-cli options (e.g. HELP, START, etc ...)
     * - The getOfbizStartupOptions method
     * Keeping these items in sync means that OFBiz behaves correctly
     * while being decoupled from the commons-cli library and the only
     * place where commons-cli is used is in this class
     */

    public enum StartupOption {
        HELP("help"),
        LOAD_DATA("load-data"),
        PORTOFFSET("portoffset"),
        SHUTDOWN("shutdown"),
        START("start"),
        STATUS("status"),
        TEST("test");

        private String name;
        StartupOption(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

}
