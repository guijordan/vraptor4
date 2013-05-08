/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.caelum.vraptor4.http.route;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor4.http.route.DefaultRouteBuilder;
import br.com.caelum.vraptor4.http.route.IllegalRouteException;
import br.com.caelum.vraptor4.http.route.JavaEvaluator;
import br.com.caelum.vraptor4.http.route.Router;
import br.com.caelum.vraptor4.http.route.Rules;

public class RulesTest {

	private @Mock Router router;
	private @Mock Proxifier proxifier;
	private DefaultRouteBuilder routeBuilder;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		routeBuilder = new DefaultRouteBuilder(proxifier, null, null, null, new JavaEvaluator(), "");
		when(router.builderFor("")).thenReturn(routeBuilder);
	}

	@Test(expected=IllegalRouteException.class)
	public void allowsAdditionOfRouteBuildersByDefaultWithNoStrategy() {
		new Rules(router) {
			@Override
			public void routes() {
				routeFor("");
			}
		};
	}
}