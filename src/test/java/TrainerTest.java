import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainerTest {


    @Test
    public void verifyIsAuthorizedTrainer(){
        //Given - ingredientele necesare pentru reteta

        Trainer trainer = new Trainer(null, null, null, true);

        //Then --reprezinta testul ca ceea ce am facut coincide cu ceea ce asteptam noi


        //WHEN +THEN
        //primul e rezultatul asteptat si a doua este ce testam
        assertTrue(trainer.isAuthorized());

    }
}
