def SolveSudoku(board):
    
    # Check if placing the number in [row][col] will produce a valid solution
    def is_valid(row, col, num):
        for i in range(9):

            # Check if the number already exists in the column
            if board[row][i] == str(num):
                return False
        
            # Check if the number already exists in the row
            if board[i][col] == str(num):
                return False

        # Checking if the number already exists in the grid
        start_row = 3 * (row // 3)
        start_col = 3 * (col // 3)
        for i in range(3):
            for j in range(3):
                if board[start_row + i][start_col + j] == str(num):
                    return False
        
        # If the number doesn't appear twice in the row, column, or grid, returns true
        return True
                

    def solve(row, col):
        
        # If we reached the last cell, solution is found
        if row == 8 and col == 9:
            return True
        
        # If we reach the end of a column, go to the beginning of the next row
        if col == 9:
            return solve(row + 1, 0)
        
        # If the cell is not filled, try possible solutions
        if board[row][col] == ".":

            for num in range(1, 10):

                # If the number is placed in a valid cell, record it
                if is_valid(row, col, num) == True:
                    board[row][col] = str(num)

                    # Recursively search for the answer in the next cell
                    if solve(row, col + 1) == True:
                            return True
                
                # If an answer could not be found down a path, remove the recorded value
                board[row][col] = "."
            
        # If the cell is already filled, go to the next one
        else:
            return solve(row, col + 1)
        
    solve(0, 0)
        

if __name__ == "__main__":
    board = [["5","3",".",".","7",".",".",".","."],
             ["6",".",".","1","9","5",".",".","."],
             [".","9","8",".",".",".",".","6","."],
             ["8",".",".",".","6",".",".",".","3"],
             ["4",".",".","8",".","3",".",".","1"],
             ["7",".",".",".","2",".",".",".","6"],
             [".","6",".",".",".",".","2","8","."],
             [".",".",".","4","1","9",".",".","5"],
             [".",".",".",".","8",".",".","7","9"]]
    
    print("Unsolved Sudoku Board: \n")
    for i in range(9):
        print(board[i], "\n")

    SolveSudoku(board)

    print("Solved Board: \n")
    for i in range(9):
        print(board[i], "\n")


    
"""
Reference:
https://www.geeksforgeeks.org/sudoku-backtracking-7/
"""