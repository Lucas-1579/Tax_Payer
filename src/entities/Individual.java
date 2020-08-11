package entities;

public class Individual extends TaxPayer {

	private Double heathExpenditues;

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double heathExpenditues) {
		super(name, anualIncome);
		this.heathExpenditues = heathExpenditues;
	}

	public Double getHeathExpenditues() {
		return heathExpenditues;
	}

	public void setHeathExpenditues(Double heathExpenditues) {
		this.heathExpenditues = heathExpenditues;
	}

	@Override
	public Double tax() {

		double basicTax = (getAnualIncome() < 20000.0) ? getAnualIncome() * 0.15 : getAnualIncome() * 0.25;
		
		basicTax -= heathExpenditues * 0.5;

		if (basicTax < 0.0) {
			basicTax = 0.0;
		}
		return basicTax;
	}

}
