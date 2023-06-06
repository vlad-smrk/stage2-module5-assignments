package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period;
    protected String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> descriptionList;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> descriptionList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.descriptionList = descriptionList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void printAllHashcodes(List<String> stringList) {
        descriptionList = new ArrayList<>(stringList);
        descriptionList.forEach(word -> System.out.println(word.hashCode()));
    }

    @FullNameProcessorGeneratorAnnotation
    public String generateName(LinkedList<String> stringList) {
        StringBuilder resultingName = new StringBuilder();
        stringList.forEach(word -> resultingName.append(word).append(' '));
        return resultingName.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        StringBuilder resultingName = new StringBuilder();
        while (informationScanner.hasNext()) {
            resultingName.append(informationScanner.nextLine());
        }
        processorName = resultingName.toString();
        informationScanner.close();
    }
}
