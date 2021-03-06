/* 
 * Copyright 2014-2016 Samsung Research America, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Unit tests for C Code generation backend, long-running tests
 *
 * @author colin.gordon
 */
package com.samsung.sjs;

import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Ignore;

public class PerfTest extends ABackendTest {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PerfTest( String testName ) throws IOException
    {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite(PerfTest.class);
    }

    @Override
    protected String getTestDir() {
        return "perf/";
    }

    public void test_matmul() {
        compilerTest();
    }
    // TODO: Move to new frontend; currently a unification error...
    public void test_spectralnorm() {
        compilerTest();
    }
    public void test_heapsort() {
        compilerTest();
    }
    public void test_partialsums() {
        compilerTest();
    }
    public void test_nsieve() {
        compilerTest();
    }
    public void test_fannkuch() {
        compilerTest();
    }
    public void test_nbody() {
        compilerTest();
    }

    // GCC runs this almost instantly, because on -O3 it precomputes the loop result and hard-codes
    // it in the assembly.
    public void test_nestedloop() {
        compilerTest();
    }
}
