#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include "BinaryTree.h"
// #include "LinkedList.h"

//TODO: Ensure Node exists in insert and delete operations.

struct binary_tree_node
{
    struct binary_tree_node *left, *right, *father;
    int value;
    int balanceFactor;
};

//find if node is leaf, return number of branches
int isLeaf(treeNode *node)
{
    int n = 0;
    if (node->right)
        n++;
    if (node->left)
        n++;
    return n;
}

treeNode *CreateTreeNode(treeNode *father, int value)
{
    treeNode *temp = calloc(1, sizeof(treeNode));
    temp->father = father;
    temp->left = NULL;
    temp->right = NULL;
    temp->value = value;
    temp->balanceFactor = 0;
    return temp;
}

treeNode *SearchTree(treeNode *node, int value)
{
    if (node->value == value || !node) //node doesnt exist or value found
        return node;

    else
    {
        // printf("Searching node: %d\n", node->value);
        if (value < node->value)
        {
            if (node->left) //check if exists
                return SearchTree(node->left, value);
            else
                return node;
        }
        else if (node->right)
            return SearchTree(node->right, value);
        else
            return node;
    }
}

void insertTreeNode(treeNode *root, int value)
{
    root = SearchTree(root, value); // returns either same value or parent value
    if (value == root->value)
        return;
    else
    {
        if (root->value > value)
            root->left = CreateTreeNode(root, value);
        else
            root->right = CreateTreeNode(root, value);
    }
}

void insertArrayIntoTree(treeNode *root, int array[], int length)
{
    for (int i = 0; i < length; i++)
    {
        insertTreeNode(root, array[i]);
    }
}

int findMin(treeNode *root)
{
    while (root->left)
    {
        root = root->left;
    }
    return root->value;
}

int findMax(treeNode *root)
{
    while (root->right)
    {
        root = root->right;
    }
    return root->value;
}

int sumTree(treeNode *root)
{
    if (!root->left && !root->right)
    {
        return root->value;
    }
    else
    {
        int sum = root->value;
        if (root->left)
            sum += sumTree(root->left);
        if (root->right)
            sum += sumTree(root->right);
        return sum;
    }
}

int sumEvenTree(treeNode *root)
{
    if (!root->left && !root->right)
    {
        return root->value;
    }
    else
    {
        int sum = (root->value % 2 == 0) ? root->value : 0;
        if (root->left)
            sum += sumTree(root->left);
        if (root->right)
            sum += sumTree(root->right);
        return sum;
    }
}

void deleteTreeNode(treeNode *node /*This should be root*/, int value)
{
    node = SearchTree(node, value);
    int n;
    if (node->value != value)
    {
        printf("ERROR FINDING VALUE\n");
        return;
    }
    if (!(n = isLeaf(node))) //Correct IF
    {
        if (node->father->value > node->value)
            node->father->left = NULL;
        else
            node->father->right = NULL;
        free(node); //free allocated memory
    }
    else if (n == 1) // CORRECT IF
    {
        if (node->left)
        {
            if (node->father->value > node->value)
                node->father->left = node->left;
            else
                node->father->right = node->left;
        }
        else
        {
            if (node->father->value > node->value)
                node->father->left = node->right;
            else
                node->father->right = node->right;
        }
        free(node); //free allocated memory
    }

    else if (n == 2)
    {
        treeNode *temp = node->right;
        while (temp->left)
        {
            temp = temp->left;
        }

        node->value = temp->value;
        deleteTreeNode(temp, temp->value);
    }
}

int max(int a, int b)
{
    return (a > b) ? a : b;
}

int height(treeNode *root)
{
    if (!root)
        return 0;
    if (root->right == NULL && root->left == NULL)
        return 1;
    else if (root->right == NULL)
        return 1 + height(root->left);
    else if (root->left == NULL)
        return 1 + height(root->right);
    return 1 + max(height(root->left), height(root->right));
}

void calculateBalanceFactor(treeNode *root)
{
    if (root)
    {
        root->balanceFactor = height(root->right) - height(root->left);
    }
}

treeNode *rotateRight(treeNode *root)
{
    if (root->left)
    {

    root->left->father = root->father;
    root->father = root->left;

    root->left = root->left->right;
    if (root->left)
        root->left->father = root;
    root->father->right = root;

    if(root->father->father){
        if (root->father->father->value > root->father->value)
            root->father->father->left = root->father;
        else
            root->father->father->right = root->father;
    }

    updateBalanceFactorUp(root);

    return root->father;
    }
    return root;
}

treeNode *rotateLeft(treeNode *root) //BUGGED
{
    if(root->right){

    root->right->father = root->father; //check
    root->father = root->right;         //check

    root->right = root->right->left;
    if (root->right)
        root->right->father = root;
    root->father->left = root;

    if (root->father->father)
    {
        if (root->father->father->value > root->father->value)
            root->father->father->left = root->father;
        else
            root->father->father->right = root->father;
    }
    updateBalanceFactorUp(root);

    return root->father;
    }
    return root;
}

int currentDepthHelper(treeNode *node, int depth)
{
    if (!node->father)
        return depth;
    else
        return (currentDepthHelper(node->father, depth + 1));
}

int currentDepth(treeNode *node)
{
    return currentDepthHelper(node, 0);
}

void printNode(treeNode *node)
{
    printf("%d\n", node->value);
}

void PrintTreeHelper(treeNode *node, int space)
{
    if (node == NULL)
        return;
    printf("\n");
    space += 10;
    PrintTreeHelper(node->right, space);
    for (int i = 10; i < space; i++)
        printf(" ");
    printf("%d\n", node->value);
    PrintTreeHelper(node->left, space);
}
void PrintTree(treeNode *root)
{
    if (!root)
        return;
    printf("Current Tree:\n");
    PrintTreeHelper(root, 0);
}

//root at the beginning
void PreorderTraversal(treeNode *root, void (*func)())
{
    if (root)
    {
        func(root);
        PreorderTraversal(root->left, func);
        PreorderTraversal(root->right, func);
    }
}

//root at the end
void PostorderTraversal(treeNode *root, treeNode *(*func)())
{
    if (root)
    {
        PostorderTraversal(root->left, func);
        PostorderTraversal(root->right, func);
        root = func(root);
    }
}

void PostorderTraversalReverse(treeNode *root, treeNode *(*func)())
{
    if (root)
    {
        PostorderTraversalReverse(root->right, func);
        PostorderTraversalReverse(root->left, func);
        root = func(root);
    }
}

//root in middle
void InorderTraversal(treeNode *root, void (*func)())
{
    if (root)
    {
        InorderTraversal(root->left, func);
        func(root);
        InorderTraversal(root->right, func);
    }
}

// print all odd values
void OddOneOut(treeNode *root)
{
    if (root)
    { // check if not null
        if (root->value % 2 != 0)
            printf("%d\n", root->value);
        OddOneOut(root->left);
        OddOneOut(root->right);
    }
}

//print values whose balance factor is 0
void balanceZero(treeNode *root)
{
    if (root)
    { // check if not null
        if (root->balanceFactor == 0)
            printf("%d\n", root->value);
        balanceZero(root->left);
        balanceZero(root->right);
    }
}

treeNode *freeNode(treeNode *node)
{
    free(node);
    return NULL;
}

void deleteTree(treeNode *root)
{
    PostorderTraversal(root, freeNode);
}

treeNode *findRoot(treeNode *node)
{
    if (node)
    {
        if (!node->father)
            return node;
        else
            return findRoot(node->father);
    }
    else
        return NULL;
}

treeNode *balanceNode(treeNode *node)
{
    printf("TREE Before Balancing Node\n");
    PrintTree(findRoot(node));
    //Assuming starting with correct balance factor
    if (node)
    {
        if (node->balanceFactor < -1)
        {
            if (node->left && node->left->balanceFactor > 0)
                node->left = rotateLeft(node->left);
            printf("Tree Before Rotation\n");
            PrintTree(findRoot(node));
            node = rotateRight(node);
        }
        if (node->balanceFactor > 1)
        {
            if (node->right && node->right->balanceFactor < 0)
                node->right = rotateRight(node->right);
            node = rotateLeft(node);
        }
        updateBalanceFactorUp(node);
    }
    return node;
}

void updateBalanceFactorUp(treeNode *node)
{
    if (node)
    {
        calculateBalanceFactor(node);
        updateBalanceFactorUp(node->father);
    }
}

void updateBalanceFactorTree(treeNode *root)
{
    PostorderTraversal(root, (void(*))calculateBalanceFactor);
}

treeNode *balanceTree(treeNode *root)
{
    PostorderTraversal(root, balanceNode);
    return findRoot(root);
}

int main(int argc, char const *argv[])
{
    treeNode *root = CreateTreeNode(NULL, 4);
    insertTreeNode(root, 2);
    insertTreeNode(root, 3);

    PrintTree(root);
    updateBalanceFactorTree(root);
    root = balanceTree(root);
    PrintTree(root);
    deleteTree(root);
    return 0;
}