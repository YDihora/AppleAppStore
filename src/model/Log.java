package model;

public class Log {

	private String Version;
	private String[] Fixes;
	private int NumberOfFixes;
	private final int MAX_NUM_OF_FIXES=100;
	
	
	
	public Log(String Version) {
		this.Version = Version;
		this.NumberOfFixes=0;
		this.Fixes= new String[MAX_NUM_OF_FIXES];
		
	}
	public String getVersion() {
		return this.Version;
	}
	public int getNumberOfFixes() {
		return this.NumberOfFixes;
	}
	public String toString() {
		String result;
		result = String.format("Version %s contains %d fixes %s",
				this.Version,
				this.NumberOfFixes,
				this.getFixes());
		return result;
	}
	public String getFixes() {
		String s;
		s="[";
		for(int i=0;i<this.getNumberOfFixes();i++) {
			s += this.Fixes[i] ;
			
			if(i<this.getNumberOfFixes()-1) {
				s+=", ";
			}
			
			
		}
		s+="]";
		return s;
	}
	public void addFix(String fix) {
		this.Fixes[this.NumberOfFixes]=fix;
		this.NumberOfFixes++;
	}
	
}
