package sivatagi_rohamcsiga;

class OilBlob extends Blob {
	public OilBlob(Vector location) {
		super(location);
	}

	public void applyEffect(Robot r) {
		r.setCanChangeSpeed(false);
	}
}
