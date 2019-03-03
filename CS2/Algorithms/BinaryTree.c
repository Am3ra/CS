#include <stddef.h>
#include <stdlib.h>
#include "BinaryTree.h"

//TODO: Ensure Node exists in insert and delete operations.

typedef struct binary_tree_node{
    struct binary_tree_node *left, *right, *father;
    int value;
} treeNode;

int isLeaf(treeNode *node){
    int n=0;
    if (node->right)
        n++;
    if (node->left)
        n++;
    return n;
}

treeNode *CreateTreeNode(treeNode *father,int value){
    treeNode *temp = malloc(sizeof(treeNode));
    temp->father = father;
    temp->value = value;
    return temp;
}

treeNode *SearchTree(treeNode *node, int value){
    if(node->value == value || !node) //node doesnt exit or value found
        return node;
    
    else
    {
        if (node->value > value) 
            if(node->left) //check if exists
                SearchTree(node->left,value);
            else
                return node;
        else
            if(node->right) // check if exists
                SearchTree(node->right,value);
            else
                return node;
    }
    return node; //Just to make compiler happy
}

void insertTreeNode(treeNode *root, int value){
    root = SearchTree(root, value); // returns either same value or parent value
    if(value == root->value){
        return;
    }
    else{
        if (root->value > value) 
            root->left = CreateTreeNode(root,value);
        else
            root->right = CreateTreeNode(root,value);
    }
}

void insertArrayIntoTree(treeNode *root, int array[], int length){
    for(int i = 0; i < length; i++)
    {
        insertTreeNode(root, array[i]);
    }
}

int findMin(treeNode *root){
    while(root->left){
        root = root->left;
    }
    return root->value;
}

int findMax(treeNode *root){
    while(root->right){
        root = root->right;
    }
    return root->value;
}

int sumTree(treeNode *root){
    if(!root->left && !root->right){
        return root->value;
    }
    else{
        int sum = root->value;
        if (root->left)
            sum += sumTree(root->left);
        if (root->right)
            sum += sumTree(root->right);
        return sum;
    }
}


int sumEvenTree(treeNode *root){
    if(!root->left && !root->right){
        return root->value;
    }
    else{
        int sum = (root->value %2 == 0) ? root->value : 0;
        if (root->left)
            sum += sumTree(root->left);
        if (root->right)
            sum += sumTree(root->right);
        return sum;
    }
}

void deleteNode(treeNode *node, int value){
    node = SearchTree(node, value);
    int n;
    if (!(n=isLeaf(node))){
        if (node->father->value > node->value) 
            node->father->left = NULL;
        else
            node->father->right = NULL;
        free(node); //free allocated memory
    }
    else if( n == 1){
        
        if (node->left) {
            if (node->father->value > node->value) 
                node->father->left = node->left;
            else
                node->father->right = node->left;
        }
        else{
            if (node->father->value > node->value) 
                node->father->left = node->right;
            else
                node->father->right = node->right;
        }
        free(node); //free allocated memory
    }
        
    else if(n == 2){
        treeNode *temp = node->right ;
        while(temp->left){
            temp = temp->left;
        } // immediate succesor

        temp -> father -> left = temp -> right; // remove and update immediate succesor
        temp -> right -> father = temp -> father;

        node->value = temp->value;

        free(temp);
    }

}