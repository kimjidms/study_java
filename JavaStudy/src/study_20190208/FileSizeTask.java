package study_20190208;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FileSizeTask  extends RecursiveTask<Long>{

	private static final long serialVersionUID = 1L;
	private final File file;
	 
	 public FileSizeTask(File file) { this.file = file; }
	 
	 protected Long compute() {
		 if (file.isDirectory()) return computeDirectory(file);
		 long size = file.length();
		 System.out.println(file.getAbsolutePath() + " " + size);
		 return size;
	 }
	 
	 private long computeDirectory(File dir) {
		 return Arrays.stream(dir.listFiles())
			 .map(FileSizeTask::new)
			 .map(ForkJoinTask::fork)
			 .map(ForkJoinTask::join)
			 .mapToLong(Long::longValue)
			 .sum();
	 } 
}
