package br.com.yanaga.samples.academico.domain;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;

import java.io.Serializable;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Ano implements Serializable, Comparable<Ano> {

	private final Year value;

	private Ano(Year value) {
		this.value = value;
	}

	public static Ano of(Date value) {
		checkNotNull(value);
		OffsetDateTime offsetDateTime =
				OffsetDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault());
		return new Ano(Year.from(offsetDateTime));
	}

	public static Ano of(String value) {
		checkNotNull(value);
		checkArgument(!Strings.isNullOrEmpty(value));
		checkArgument(value.matches("\\d+"));
		return new Ano(Year.parse(value));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ano) {
			Ano other = (Ano) obj;
			return Objects.equal(this.value, other.value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.value);
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public int compareTo(Ano o) {
		return ComparisonChain.start().compare(this.value, o.value).result();
	}

	public Date toDate() {
		return new Date(value.atMonthDay(MonthDay.of(1, 1)).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli());
	}

}
