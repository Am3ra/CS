#pragma once

typedef struct binary_tree_node treeNode;

treeNode *CreateTreeNode(treeNode *father,int value);

treeNode *SearchTree(treeNode *node, int value);

void calculateBalanceFactor(treeNode *root);

void PreorderTraversal(treeNode *root, void (*func)());

int currentDepth(treeNode *node);

void freeTreeNode(treeNode *node);

void updateBalanceFactorUp(treeNode *node);