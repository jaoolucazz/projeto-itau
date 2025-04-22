package desafio.itau.back_end.dto;

import java.util.DoubleSummaryStatistics;

public class Estatistica {
    
    private Long count;
    private Double sum;
    private Double min;
    private Double max;
    private Double avg; 


    public Estatistica(DoubleSummaryStatistics  status){
        this.count = status.getCount();
        this.sum = status.getSum();
        this.min = status.getMin();
        this.max = status.getMax();
        this.avg = status.getAverage();
    }

    public Long getCount() {
        return count;
    }

    public Double getSum() {
        return sum;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }

    public Double getAvg() {
        return avg;
    }

    
}
