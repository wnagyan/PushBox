package pushbox;

public class Backup {
	private int[][] backupmap;
	private int backupmanx;
	private int backupmany;
	private int backuplasting;
	public int[][] getBackupmap() {
		return backupmap;
	}
	public void setBackupmap(int[][] backupmap) {
		this.backupmap = backupmap;
	}
	public int getBackupmanx() {
		return backupmanx;
	}
	public void setBackupmanx(int backupmanx) {
		this.backupmanx = backupmanx;
	}
	public int getBackupmany() {
		return backupmany;
	}
	public void setBackupmany(int backupmany) {
		this.backupmany = backupmany;
	}
	public int getBackuplasting() {
		return backuplasting;
	}
	public void setBackuplasting(int backuplasting) {
		this.backuplasting = backuplasting;
	}
	public Backup(int manx, int many, int[][] ditu, int lasting) {
		// TODO Auto-generated constructor stub
		this.backupmanx = manx;
		this.backupmany = many;
		this.backuplasting = lasting;
		this.backupmap = ditu;
	}
}
