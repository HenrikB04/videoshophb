/*
 * Copyright 2013-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package videoshop.catalog;

import static org.salespointframework.core.Currencies.*;

import videoshop.catalog.Disc.DiscType;

import org.javamoney.moneta.Money;
import org.salespointframework.core.DataInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * A {@link DataInitializer} implementation that will create dummy data for the application on application startup.
 *
 * @author Paul Henke
 * @author Oliver Gierke
 * @see DataInitializer
 */
@Component
@Order(20)
class CatalogDataInitializer implements DataInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogDataInitializer.class);

	private final VideoCatalog videoCatalog;

	CatalogDataInitializer(VideoCatalog videoCatalog) {

		Assert.notNull(videoCatalog, "VideoCatalog must not be null!");

		this.videoCatalog = videoCatalog;
	}

	/*
	 * (non-Javadoc)
	 * @see org.salespointframework.core.DataInitializer#initialize()
	 */
	@Override
	public void initialize() {

		if (videoCatalog.findAll().iterator().hasNext()) {
			return;
		}

		LOG.info("Creating default catalog entries.");

		videoCatalog.save(new Disc("Last Action Hero", "lac", Money.of(100, EURO), "Äktschn/Comedy", DiscType.DVD, "07.10.1993"));
		videoCatalog.save(new Disc("Back to the Future", "bttf", Money.of(9.99, EURO), "Sci-Fi", DiscType.DVD, "03.07.1985"));
		videoCatalog.save(new Disc("Fido", "fido", Money.of(9.99, EURO), "Comedy/Drama/Horror", DiscType.DVD, "07.09.2006"));
		videoCatalog.save(new Disc("Super Fuzz", "sf", Money.of(9.99, EURO), "Action/Sci-Fi/Comedy", DiscType.DVD, "18.09.1980"));
		videoCatalog.save(new Disc("Armour of God II: Operation Condor", "aog2oc", Money.of(14.99, EURO),
				"Action/Adventure/Comedy", DiscType.DVD, "07.02.1991"));
		videoCatalog.save(new Disc("Persepolis", "pers", Money.of(14.99, EURO), "Animation/Biography/Drama", DiscType.DVD, "22.11.2007"));
		videoCatalog
				.save(new Disc("Hot Shots! Part Deux", "hspd", Money.of(9999.0, EURO), "Action/Comedy/War", DiscType.DVD, "23.09.1993"));
		videoCatalog.save(new Disc("Avatar: The Last Airbender", "tla", Money.of(19.99, EURO), "Animation/Action/Adventure",
				DiscType.DVD, "19.08.2010"));
		videoCatalog.save(new Disc("Stromberg", "strmbrg", Money.of(11.99, EURO), "Comedy", DiscType.DVD, "20.02.2014"));

		videoCatalog.save(new Disc("Secretary", "secretary", Money.of(6.99, EURO), "Political Drama", DiscType.BLURAY, "25.09.2003"));
		videoCatalog.save(new Disc("The Godfather", "tg", Money.of(19.99, EURO), "Crime/Drama", DiscType.BLURAY, "14.03.1972"));
		videoCatalog
				.save(new Disc("No Retreat, No Surrender", "nrns", Money.of(29.99, EURO), "Martial Arts", DiscType.BLURAY, "20.10.1985"));
		videoCatalog
				.save(new Disc("The Princess Bride", "tpb", Money.of(39.99, EURO), "Adventure/Comedy/Family", DiscType.BLURAY, "18.09.1987"));
		videoCatalog.save(new Disc("Top Secret!", "ts", Money.of(39.99, EURO), "Comedy", DiscType.BLURAY, "22.06.1984"));
		videoCatalog
				.save(new Disc("The Iron Giant", "tig", Money.of(34.99, EURO), "Animation/Action/Adventure", DiscType.BLURAY, "16.12.1999"));
		videoCatalog.save(new Disc("Battle Royale", "br", Money.of(19.99, EURO), "Action/Drama/Thriller", DiscType.BLURAY, "31.10.2000"));
		videoCatalog.save(new Disc("Oldboy", "old", Money.of(24.99, EURO), "Action/Drama/Thriller", DiscType.BLURAY, "05.12.2013"));
		videoCatalog.save(new Disc("Bill & Ted's Excellent Adventure", "bt", Money.of(29.99, EURO),
				"Adventure/Comedy/Family", DiscType.BLURAY, "17.02.1989"));
	}
}
