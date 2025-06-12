package candidatura.util;

public class SelectiveProcess {

    public void checkCandidate(double intendedSalary, double note) {
        try {
            double baseSalary = Constants.BaseSalary.getSalary(note, 0, 5);

            if(baseSalary > intendedSalary){
                System.out.println("LIGAR PARA CANDIDATO" + " | "+  intendedSalary +" / "+baseSalary);
            } else if (baseSalary == intendedSalary) {
                System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA"+ " | "+  intendedSalary +" / "+baseSalary);
            } else {
                System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS"+ " | "+  intendedSalary +" / "+baseSalary);
            }

        }catch (IllegalArgumentException e){
            System.out.printf("A nota %s causou um erro, pois é: %s", note, e.getMessage());
        }
    }

}
