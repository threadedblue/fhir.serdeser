package org.hl7.fhir.emf;

public abstract class Finals {
	public static final String FHIR_PACKAGE = "org.hl7.fhir";
	public static final String YMD = "yyyy-MM-dd";
	public static final String YMDhms = "yyyy-MM-dd'T'hh:mm:ssZ";
	public static final String hms = "hh:mm:ss";
	public static final String SCHEME = "inmemory";
//	public enum SDS_FORMAT {XML, JSON, RDF_TTL, RDF_N3, AA, ECORE}

	public enum SDS_FORMAT {
		XML,               // defaults to "xml"
		JSON,              // defaults to "json"
		RDF_TTL("ttl"), // custom value
		RDF_N3("n3"),            // defaults to "rdf_n3"
		AA("csv"),                // defaults to "aa"
		ECORE,
		RCVS;    // custom value

		private final String value;

		// No-argument constructor uses the enum constant's name in lowercase.
		SDS_FORMAT() {
			this.value = this.name().toLowerCase();
		}

		// Constructor with a custom value.
		SDS_FORMAT(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
}