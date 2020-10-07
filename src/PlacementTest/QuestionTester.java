package PlacementTest;

import jsjf.LinkedBinaryTree;
import java.util.Scanner;

public class QuestionTester {

    public static void main(String[] args) {

        Question q1 = new Question("Which tree traversal follows the order "
                + "of root, left, right?", "Preorder");
        Question q2 = new Question("Which tree traversal follows the order "
                + "of left, root, right?", "Inorder");
        Question q3 = new Question("What connects one node to another?",
                "Edges");
        Question q4 = new Question("Which tree traversal follows the order "
                + " of left, right, root?", "Postorder");
        Question q5 = new Question("Are Trees a linear structure?", "No");
        Question q6 = new Question("What shows the relationship among operators"
                + " and operands?", "Expression Tree");
        Question q7 = new Question("What is the height of the root node?",
                "0");
        LinkedBinaryTree<Question> questionTreeLeft2
                = new LinkedBinaryTree<>(q6);

        LinkedBinaryTree<Question> questionTreeRight2
                = new LinkedBinaryTree<>(q7);

        LinkedBinaryTree<Question> questionTreeLeft1
                = new LinkedBinaryTree<>(q4);

        LinkedBinaryTree<Question> questionTreeRight1
                = new LinkedBinaryTree<>(q5);

        LinkedBinaryTree<Question> questionTreeLeft
                = new LinkedBinaryTree<>(q2, questionTreeLeft1,
                        questionTreeRight1);

        LinkedBinaryTree<Question> questionTreeRight
                = new LinkedBinaryTree<>(q3, questionTreeLeft2,
                        questionTreeRight2);

        LinkedBinaryTree<Question> questionTree
                = new LinkedBinaryTree<>(q1, questionTreeLeft, questionTreeRight);
        
        
        Boolean done = false;
        while (!done) {
            System.out.println("Capitalize FIRST letter in answer");
            System.out.println(questionTree.getRootElement().getQuestion());
            String answer;
            String nextQuestion;
            Scanner scan = new Scanner(System.in);
            answer = scan.nextLine();
            if(questionTree.getRootElement().getAnswer().equals(answer)){
                nextQuestion = questionTree.getLeft().getRootElement().getQuestion();
                System.out.println(nextQuestion);
                answer = scan.nextLine();
                if (questionTree.getLeft().getRootElement().getAnswer().equals(answer)){
                   nextQuestion = questionTree.getLeft().getLeft().getRootElement().getQuestion();
                    System.out.println(nextQuestion);
                    answer = scan.nextLine();
                }else{
                    nextQuestion = questionTree.getLeft().getRight().getRootElement().getQuestion();
                    System.out.println(nextQuestion);
                    answer = scan.nextLine();
                    if(questionTree.getLeft().getRight().getRootElement().getAnswer().equals(answer)){
                        System.out.println("Congrats you finished on leaf node #2 with a 66%");
                        done = true;
                    }else{
                        System.out.println("You finished on leaf node #2 with a 33%");
                        done = true;
                    }
                    
                }
                if(questionTree.getLeft().getLeft().getRootElement().getAnswer().equals(answer)){
                    System.out.println("Congrats, you got all answers correct" 
                    + ", You ended on leaf number 1 which is a 100%");
                    done = true;
                }else{
                    System.out.println("You ended on leaf node #1 with a 66%");
                    done = true;
                }
            }else{
                nextQuestion = questionTree.getRight().getRootElement().getQuestion();
                System.out.println(nextQuestion);
                answer = scan.nextLine();
                if(questionTree.getRight().getRootElement().getAnswer().equals(answer)){
                    nextQuestion = questionTree.getRight().getLeft().getRootElement().getQuestion();
                    System.out.println(nextQuestion);
                    answer = scan.nextLine();
                    if(questionTree.getRight().getLeft().getRootElement().getAnswer().equals(answer)){
                        System.out.println("Congrats You finished on leaf node #3, You got a 66%");
                        done = true;
                    }else{
                        System.out.println("You finished on leaf node #3 with a 33%");
                        done = true;
                    }
                }else{
                    nextQuestion = questionTree.getRight().getRight().getRootElement().getQuestion();
                    System.out.println(nextQuestion);
                    answer = scan.nextLine();
                    if(questionTree.getRight().getRight().getRootElement().getAnswer().equals(answer)){
                        System.out.println("You finished on leaf node #4, You got a 33%");
                        done = true;
                    }else{
                        System.out.println("Bummer, you finished on leaf node #4, you got a 0%");
                        done = true;
                    }
                }
                
            }
        }
    }

}
