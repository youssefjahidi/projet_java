package myUber;

public interface UberVisitor {
	double visit(UberX UberX);
	double visit(UberVan UberVan);
	double visit(UberPool uberpool);
	double visit(UberBlack uberblack);
}
