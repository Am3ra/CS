#include <stdio.h>
#include <math.h>
#include <stdbool.h>

/**  
 * How a node should be processed:
 * Consider the simplest case, 1 node 
 * IFF value = -1
 * in this case, there are 0 test patter.
 * if value = 0
 * there is 3 test patterns, input {0,1},{1,0},{0,0} -> should produce 1, but produce 0
 * if value = 1
 * there is 1 test pattern: input {1,1} -> should produce 0, but produces 1
 */

/**
 * Case 2 nodes, 
 *  2
    2 0 1
    0 0 -1
 * Because output node is stuck, in 1, if both inputs to it are 0, output is a test pattern
 * So now we need to find how many ways both inputs can be 0.
 * because the right input is variable, its only 1
 * left input is another node, so we have to check how many ways IT can be 1.
 * left input is correctly functioning, so only ways for 1 output is {0,1},{1,0},{0,0}
 * Then evaluate right input, see how many cases it can be 1 -> 1 case
 * Multiply both inputs - 3 * 1 and  you get 3
 * 
 * 
 * Now lets do the excersize in the case of node 1 being stuck on 0:
 * 
 *  2
    2 0 0
    0 0 -1
 * 
 * First, we check the truth table to see which cases should give 1, but wouldn't because
 * the gate is stuck on 0: {0,0},{0,1},{1,0}.
 * 
 * Question, inside each pair of wrong inputs, the possibility of each is multiplied. 
 * Is the possibility of each pair total added or multiplied? I think added.
 * 
 * so cases 1: {0,0}:
 * 
 * left can be 0 in 1 case, right in 1, total 1.
 * 
 * case 2: {0,1}
 * left 0 in 1, right 1 in 1, total 1
 * 
 * case 3: {1,0}
 * left 1 in 3, right 1 in 1, total  3,
 * 
 * Sum of all cases: 5 <- i think this is the answer.
*/

/**
 * So what have I learned?
 * 
 * 1st step: Evaluate the output node.
 *     If value is correct, evaluate inputs... not sure if add or mult...I think add.
 * 2nd step: If evaluated node is stuck, check in how many cases the opposite is true.
 * if one input is external, answer is 1 case.
 * if input is gate:
 *      if gate is stuck on 0, output of evaluated node is always 1 what does this mean?
 *      probably means that evaluated node is effectively stuck on 1.
 * 
 */

/**
 * Algorithm i found...
 * start at output node (node 1)
 * 
 * check if node is stuck
 * 
 * if stuck()
 * check in how many cases inputs have certain values.. 
 * dont care if any node below is stuck 
 * 
 * if not stuck...
 * multiply error cases of left and right node. repeat process with left and right.
 */
typedef struct NodeStruct
{
    int value, left, right;
} Node;

bool isLeaf(Node element)
{
    if (!element.left && !element.right)
        return true;
    return false;
}

/**
 * Evaluate in how many cases a node outputs a value.
 * 
 * if output is 0, evaluate cases in which inputs are one.
 * 
 * if output is one, evaluate {0,0},{0,1},{1,0}
 * 
 * So: evalute input 1 of each input regardless and save the numbers.
 * 
 * then, if 0, multiply and return,
 * and if 1, evaluate 0 for both as well and return sum of multiples.
 * 
 * how to evaluate inputs : if gate, evaluate gate for expected value. 
 *      if external input, there is only 1 case for it.
 * 
 */

int evalNode(int element, Node array[], int expectedValue)
{
#ifdef DEBUG   
    printf("Current node: %d, expectedValue %d\n",element, expectedValue);
#endif //DEBUG 
    if (!element) //If it's external input(0), return 1 always
        return 1;

    //Always have to evaluate inputs 1 state, regardless.
    int left_one = evalNode(array[element - 1].left, array, 1);
    int right_one = evalNode(array[element - 1].right, array, 1);

    if (!expectedValue){
#ifdef DEBUG
        printf("evaluation of node %d, %d, %d\n", element, left_one * right_one,expectedValue);
#endif //DEBUG
        return left_one * right_one;
    } //expected value is 0
    else
    { //expected value is 1
        int left_0 = evalNode(array[element - 1].left, array, 0);
        int right_0 = evalNode(array[element - 1].right, array, 0);
        int result = left_0 * right_one;
        result += left_one * right_0;
        result += left_0 * right_0;
#ifdef DEBUG
        printf("evaluation of node %d, %d, %d\n", element, result, expectedValue);
#endif //DEBUG
        return result;
    }
}

int evalStuckNode(int element, Node array[])
{
#ifdef DEBUG
    printf("Current stuck evaluation node: %d\n", element);
#endif //DEBUG
    if(!element)
        return 0; // this is bugged?
    if(array[element-1].value != -1){ // element is stuck
        
#ifdef DEBUG
        // printf("stuck node: %d\n", element);
#endif

        if (array[element - 1].value == 1) // stuck in 1
            return evalNode(element, array, 0);
        else
            return evalNode(element, array, 1);
    }
    else
    {
        int left  = evalStuckNode(array[element - 1].left, array);
        int right = evalStuckNode(array[element - 1].right, array);
#ifdef DEBUG  

#endif //DEBUG
        if(!left && !right)
            return 1;
        else 
            if(!left)
                return right;
            if(!right)
                return left;
            return left*right;

    }
}

int main(int argc, char const *argv[])
{
    int MaxGates;
    unsigned long result;
    while (scanf("%d\n", &MaxGates) == 1)
    {
        result = 1;

#ifdef DEBUG
        printf("%d\n", MaxGates);
#endif

        Node NodeArray[MaxGates];
        for (int i = 0; i < MaxGates; i++)
        {
            scanf("%d %d %d\n", &NodeArray[i].left, &NodeArray[i].right, &NodeArray[i].value);
        }

#ifdef DEBUG
        for (int i = 0; i < MaxGates; i++)
        {
            printf("%d %d %d\n", NodeArray[i].left, NodeArray[i].right, NodeArray[i].value);
        }
#endif

        printf("result: %d\n\n",evalStuckNode(1,NodeArray));
        // NOTE: indeces in left and right are 1 bigger that array index

        // printf("%lu\n", result % ((int)pow(10, 9) + 7));
    }

    // printf("%f\n",pow(10,9)+7);
    return 0;
}
