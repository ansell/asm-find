/*
 * Copyright (c) 2017, Peter Ansell
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * * Neither the name of the copyright holder nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.ansell.asm;

import java.io.FileNotFoundException;
import java.nio.file.Path;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import joptsimple.OptionException;

/**
 * Tests for {@link ASMFinder}.
 * 
 * @author Peter Ansell p_ansell@yahoo.com
 */
public class ASMFinderTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Rule
	public TemporaryFolder tempDir = new TemporaryFolder();

	/**
	 * Test method for
	 * {@link com.github.ansell.asm.ASMFinder#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainNoArgs() throws Exception {
		thrown.expect(OptionException.class);
		ASMFinder.main();
	}

	/**
	 * Test method for
	 * {@link com.github.ansell.asm.ASMFinder#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainHelp() throws Exception {
		ASMFinder.main("--help");
	}

	/**
	 * Test method for
	 * {@link com.github.ansell.asm.ASMFinder#main(java.lang.String[])}.
	 */
	@Test
	public final void testMainFileDoesNotExist() throws Exception {
		Path testDirectory = tempDir.newFolder("test-does-not-exist").toPath();

		thrown.expect(FileNotFoundException.class);
		ASMFinder.main("--input", testDirectory.resolve("test-does-not-exist.jar").toString());
	}


}
