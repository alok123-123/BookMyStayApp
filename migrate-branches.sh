#!/bin/bash
set -euo pipefail

# Multi-branch migration script for repository transfer.
# Source repo: https://github.com/Sahil-2006/BookMyStayApp
# Target repo: https://github.com/alok123-123/BookMyStayApp

if [ -z "${1-}" ]; then
  echo "Usage: $0 <target-remote-name> [branch1 branch2 ...]"
  echo "Example: $0 alok main dev feature/UC1-WelcomePage ..."
  exit 1
fi

target_remote="$1"
shift

if ! git rev-parse --is-inside-work-tree >/dev/null 2>&1; then
  echo "Error: not inside a git repository." >&2
  exit 2
fi

if ! git remote get-url "$target_remote" >/dev/null 2>&1; then
  echo "Error: remote '$target_remote' does not exist. Add it first with 'git remote add $target_remote <url>'." >&2
  exit 3
fi

# Default branch list if none provided by caller
branches=(
  main
  dev
  feature/UC1-WelcomePage
  UC2-HotelRoomInitialization
  UC3-CentralizedRoomInventoryManagement
  UC4-RoomSearchAndAvailabilityCheck
  UC5-BookingRequest
  UC6-ReservationConfirmationAndRoomAllocation
  UC7-AddOnServiceSelection
  UC8-BookingHistoryAndReporting
  UC9-ErrorHandlingAndValidation
  UC10-BookingCancellationAndInventoryRollback
  UC11-ConcurrentBookingSimulation
  UC12-DataPersistencyAndSystemRecovery
)

if [ "$#" -gt 0 ]; then
  branches=("$@")
fi

for branch in "${branches[@]}"; do
  echo "=== Processing branch: $branch ==="
  if git show-ref --verify --quiet "refs/heads/$branch"; then
    git checkout "$branch"
  else
    echo "Branch '$branch' does not exist locally. Trying to fetch from origin..."
    git fetch origin "$branch":"$branch"
    git checkout "$branch"
  fi

  git add -A
  git commit --allow-empty -m "alok added $branch" || true
  git push "$target_remote" "$branch"
  echo "Branch '$branch' pushed to '$target_remote'."
  echo
done

echo "Done: all branches pushed to $target_remote."