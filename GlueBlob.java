package sivatagi_rohamcsiga;

class GlueBlob extends Blob {
	public GlueBlob(Vector location) {
		super(location);
	}

	public void applyEffect(Robot r) {
		Vector speed = r.getSpeed();
		speed.setX(speed.getX() / 2);
		speed.setY(speed.getY() / 2);
		// referencia átadás miatt működik
	}
}
